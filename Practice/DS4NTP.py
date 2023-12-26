import ntplib
from time import ctime

c = ntplib.NTPClient()
response = c.request("pool.ntp.org")
local = ctime(response.tx_time)

print(local)