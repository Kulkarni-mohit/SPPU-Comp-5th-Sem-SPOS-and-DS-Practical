import socket

host = '127.0.0.1'
port = 8080

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect((host,port))

mess = input("Enter Message: ")

while True:
    client.send(mess.encode())
    data= client.recv(1024)
    print(data.decode())

    mess = input("Enter another Message: ")
    if not mess:
        break
client.close()