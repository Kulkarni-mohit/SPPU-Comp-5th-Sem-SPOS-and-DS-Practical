from xmlrpc.client import *

proxy = ServerProxy("http://localhost:8000")

res = proxy.Add(1,2)

r = proxy.Sub(1,2)

print(res,r)