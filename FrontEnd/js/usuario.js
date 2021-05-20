
function logar() {

    if (document.getElementById("txtEmail").value == "" || document.getElementById("txtSenha").value == ""){
        alerta("O preenchimento dos campos E-mail e senha é obrigatório")
        return;
    }
    
    var ver = document.getElementById("txtEmail").value
    if (ver.indexOf("@")){
        var usuario = {
            email: document.getElementById("txtEmail").value,
            senha: document.getElementById("txtSenha").value
        };
    }else{
        var usuario = {
            racf: document.getElementById("txtEmail").value,
            senha: document.getElementById("txtSenha").value
        };

    }
    

  
    var envelope = {
        method: "POST",
        body: JSON.stringify(usuario),
        headers: {
            "content-type": "application/json"
        }

    };

    fetch("http://localhost:8080/login", envelope)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("userlogado", JSON.stringify(res));
            window.location = "principal.html";

        })
        .catch(err => {
           alerta("Usuário e/ou senha inválido");
        });


}
function exibirusuario() {


    var userstr = localStorage.getItem("userlogado");

    if (userstr == null) {
        window.location = "login.html";
    } else {
        var userjson = JSON.parse(userstr);
        document.getElementById("nome").innerHTML=userjson.nome + " (" +  userjson.racf + ")";
        document.getElementById("foto").innerHTML = "<img src=../imagens/" + userjson.foto + " width='140' height='auto'>";
        exibirparceiro();
    }

}

function comboparceiro() {
    
    fetch("http://localhost:8080/agentesfinanceiros")
        .then(res => res.json())
        .then(res => {
            var resposta = "";
            for (contador = 0; contador < res.length; contador++) {
                resposta +=
                    "<option value='" + res[contador].id + "'>" +
                    res[contador].nomeArtistico + "</option>";
            }
            document.getElementById("cmaParceiro").innerHTML = resposta;
        })
        .catch(err => {
            alerta("Não foram encontrados parceiros para o combo")
        });
}

function exibirparceiro() {

    fetch("http://localhost:8080/parceiros/")
        .then(res => res.json())
        .then(res => {
            var resposta = "";
            var html = "";
            html += "<table  class='table' width='80%'>";
            html += "<tr class='h5'><td>Música</td>";
            html += "<td>Cadastro</td>";
            html += "<td>Lançamento</td></tr>";


            for (contador = 0; contador < res.musicas.length; contador++) {
                lancamento = "Não";
                if (res.musicas[contador].lancamento == 1) {
                    lancamento = "Sim";
                }
                html += "<tr>";
                html += "<td>" + res.musicas[contador].titulo + "</td>";
                html += "<td>" + res.musicas[contador].cadastro + "</td>";
                html += "<td>" + lancamento + "</td>";
                html += "</tr>";

            }


            html += "</table>";
            document.getElementById("parceiros").innerHTML = html;
        })
        .catch(err => {
            document.getElementById("parceiros").innerHTML="<div class='alert alert-warning' role='alert'>Não foi encontrado nenhum Top 10</div>";
        });

        comboparceiro();

}
function filtrar(){
    alert(document.getElementById("cmaParceiro").value);

}

function alerta(msg){
    var html="";
    html += "<div class='alert alert-warning alert-dismissible fade show' role='alert'>";
    html += msg;
    html += "  <button type='button' class='close' data-dismiss='alert' aria-label='Close'>";
    html += "    <span aria-hidden='true'>&times;</span>";
    html += "  </button>";
    html += "</div>";
    document.getElementById("alerta").innerHTML=html;
}

function sair(){
    window.localStorage.removeItem("userlogado");
    window.location="principal.html";
    }