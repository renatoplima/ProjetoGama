
function logar() {

    if (document.getElementById("txtEmail").value == "" || document.getElementById("txtSenha").value == ""){
        alerta("O preenchimento dos campos E-mail e senha é obrigatório")
        return;
    }
    
    var ver = document.getElementById("txtEmail").value
    if (ver.indexOf("@") != -1){
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
           alerta("Usuário e/ou Senha inválido(s)");
        });


}
function exibirusuario() {


    var userstr = localStorage.getItem("userlogado");

    if (userstr == null) {
        window.location = "../html/login.html";
    } else {
        var userjson = JSON.parse(userstr);
        document.getElementById("nome").innerHTML=userjson.nome + " (" +  userjson.racf + ")";
        document.getElementById("foto").innerHTML = "<img src=../imagens/" + userjson.foto + " width='140' height='auto'>";
        //alert("passou exibirusuario");
        exibirparceiro();
    }

}

function comboparceiro() {
    
    fetch("http://localhost:8080/agentes")
        .then(res => res.json())
        .then(res => {
            var resposta = "";
            for (contador = 0; contador < res.length; contador++) {
                resposta += "<option value='" + res[contador].idAgente + "'>" +
                    res[contador].nomeAgente + "</option>";
            }
            document.getElementById("cmaParceiro").innerHTML = resposta;
        })
        .catch(err => {
            alerta("Não foram encontrados parceiros para o combo")
        });
}

function exibirparceiro() {

    fetch("http://localhost:8080/topagentesfinanceiros/")
        .then(res => res.json())
        .then(res => {
            var resposta = "";
            var html = "";
            html += "<table  class='table' width='100%'>";
            html += "<tr class='h5'><td>ID Agente</td>";
            html += "<td>Nome</td>";
            html += "<td>Volume Transacional</td></tr>";

            for (contador = 0; contador < res.length; contador++) {
                html += "<tr>";
                html += "<td>" + res[contador].idAgente + "</td>";
                html += "<td>" + res[contador].nomeAgente + "</td>";
                html += "<td>" + res[contador].volumeTransacional + "</td>";
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

    fetch("http://localhost:8080/agenteid/" + document.getElementById("cmaParceiro").value)
    .then(res => res.json())
    .then(res => {
        localStorage.setItem("code",JSON.stringify(res.idAgente));
        localStorage.setItem("nomeag",JSON.stringify(res.nomeAgente));
        localStorage.setItem("transac",JSON.stringify(res.volumeTransacional));
        window.location="../html/dashparceiro.html";
})

}

function carregarDash(){
    var userstr = localStorage.getItem("userlogado");
    if (userstr == null) {
        window.location = "../html/login.html";
    }
    var nomeparceiro = localStorage.getItem("nomeag")
    var transac = localStorage.getItem("transac")
    var idparceiro = localStorage.getItem("code")
    document.getElementById('cmparceiro').innerHTML= nomeparceiro.replace(/"/g,"") + " / Transações: " + transac;
    exibirsucesso(idparceiro);
    exibirfalha(idparceiro);
    exibirfraude(idparceiro);
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
    window.localStorage.removeItem("code");
    window.localStorage.removeItem("nomeag");
    window.localStorage.removeItem("transac");
    window.alert("Logoff efetuado com sucesso!");
    window.location="login.html";
    }


//_________________________________________________________________

function exibirsucesso(cod){
    
    fetch("http://localhost:8080/transacao/" + cod + "/0")
    .then(res => res.json())
    .then(res => {
        //"<h3 style='text-align: end;'>" + res + "</h3>";
        document.getElementById('cmsucessos').innerHTML= res;
    })
}

function exibirfraude(cod){
    
    fetch("http://localhost:8080/transacao/" + cod + "/2")
    .then(res => res.json())
    .then(res => {
        document.getElementById('cmfraudes').innerHTML= res;
    })
}

function exibirfalha(cod){
    
    fetch("http://localhost:8080/transacao/" + cod + "/1")
    .then(res => res.json())
    .then(res => {
        document.getElementById('cmfalhas').innerHTML= res;
    })
}
