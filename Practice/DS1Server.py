import socket
import threading

def client_handler(client):
    while True:
        data = client.recv(1024)
        client.send(data)

host = '127.0.0.1'
port = 8080

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind((host,port))
server.listen(5)

while True:
    client,addr = server.accept()
    thread = threading.Thread(target=client_handler, args=(client,))
    thread.start()