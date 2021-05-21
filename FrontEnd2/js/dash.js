function exibirsucesso(){
    
    fetch("http://localhost:8080/exibirsucesso/" + document.getElementById("cmsucessos").value)
    .then(res => res.json())
    .then(res => {
        "<h3 style='text-align: end;'>" + res + "</h3>";
    })
}

function exibirfalha(){
    
    fetch("http://localhost:8080/exibirfalha/" + document.getElementById("cmfalhas").value)
    .then(res => res.json())
    .then(res => {
        "<h3 style='text-align: end;'>" + res + "</h3>";
    })
}


