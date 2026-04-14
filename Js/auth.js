// NAVBAR DINÁMICO
const authArea = document.getElementById("authArea");
const usuario = localStorage.getItem("usuario");

if (usuario) {
    authArea.innerHTML = `
        <span class="me-2">👤 ${usuario}</span>
        <button onclick="logout()" class="btn btn-danger btn-sm">Salir</button>
    `;
} else {
    authArea.innerHTML = `
        <button class="btn-login-custom" data-bs-toggle="modal" data-bs-target="#authModal">
            <i class="bi bi-person-circle me-1"></i> Iniciar sesión
        </button>
    `;
}

function logout() {
    localStorage.removeItem("usuario");
    location.reload();
}


// CAMBIO LOGIN / REGISTER
let modoLogin = true;

function toggleAuth() {
    modoLogin = !modoLogin;

    document.getElementById("loginForm").style.display = modoLogin ? "block" : "none";
    document.getElementById("registerForm").style.display = modoLogin ? "none" : "block";

    document.getElementById("toggleBtn").textContent = modoLogin
        ? "¿No tienes cuenta? Regístrate"
        : "¿Ya tienes cuenta? Inicia sesión";

    document.getElementById("mensaje").style.display = "none";
}


// LOGIN
document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const user = document.getElementById("loginUser").value;
    const pass = document.getElementById("loginPass").value;

    let usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];

    let encontrado = usuarios.find(u => u.user === user && u.pass === pass);

    if (encontrado) {
        localStorage.setItem("usuario", user);

        const modal = bootstrap.Modal.getInstance(document.getElementById('authModal'));
        modal.hide();

        location.reload();
    } else {
        mostrarMensaje("Usuario o contraseña incorrectos");
    }
});


// REGISTRO
document.getElementById("registerForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const user = document.getElementById("regUser").value;
    const pass = document.getElementById("regPass").value;

    let usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];

    let existe = usuarios.find(u => u.user === user);

    if (existe) {
        mostrarMensaje("El usuario ya existe");
        return;
    }

    usuarios.push({ user, pass });
    localStorage.setItem("usuarios", JSON.stringify(usuarios));

    mostrarMensaje("Registro exitoso ✅", "green");

    toggleAuth();
});


function mostrarMensaje(texto, color = "red") {
    const msg = document.getElementById("mensaje");
    msg.style.display = "block";
    msg.style.color = color;
    msg.textContent = texto;
}