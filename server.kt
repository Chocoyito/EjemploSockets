import java.net.ServerSocket

fun main() {
    val serverSocket = ServerSocket(8080)
    println("Servidor iniciado en el puerto ${serverSocket.localPort}")
    
    while (true) {
        val socket = serverSocket.accept()
        println("Nueva conexión desde ${socket.inetAddress}:${socket.port}")
        
        val input = socket.getInputStream().bufferedReader().readLine()
        println("Mensaje recibido: $input")
        
        val output = "Respuesta desde el servidor"
        socket.getOutputStream().write(output.toByteArray())
        
        socket.close()
        println("Conexión cerrada")
    }
}
