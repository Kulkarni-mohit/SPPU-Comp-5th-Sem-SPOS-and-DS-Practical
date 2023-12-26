class Process:
    def __init__(self):
        self.tick = 0

    def get_time(self):
        return self.tick
    
    def tick_(self):
        self.tick+=1

clock1 = Process()
clock2 = Process()

print(clock1.get_time())

clock1.tick_()
clock2.tick_()
if clock1.get_time() < clock2.get_time():
    print("clock2 is ahead")

elif clock1.get_time() >clock2.get_time():
    print("clock1 is ahead")

else:
    print("both are synchronized")