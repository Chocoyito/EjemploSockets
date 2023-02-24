import java.net.Socket

fun main() {
    val host = "localhost"
    val port = 8080
    
    val socket = Socket(host, port)
    println("Conectado al servidor $host:$port")
    
    val output = "Mensaje desde el cliente"
    socket.getOutputStream().write(output.toByteArray())
    
    val input = socket.getInputStream().bufferedReader().readLine()
    println("Respuesta recibida: $input")
    
    socket.close()
    println("Conexión cerrada")
}
