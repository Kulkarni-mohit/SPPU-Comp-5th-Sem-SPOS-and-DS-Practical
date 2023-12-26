from xmlrpc.server import *

class Maths:
    def Add(self,a,b):
        return a+b
    def Sub(self,a,b):
        return a-b
    

server = SimpleXMLRPCServer(("localhost", 8000))

server.register_instance(Maths())

server.serve_forever()