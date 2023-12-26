# class Node:
#     def __init__(self, id):
#         self.id = id
#         self.coordinator = None

#     def ring(self,nodes):
#         print(f'{self.id} sent message')
#         max_id = max(node.id for node in nodes)
#         if self.id == max_id:
#             self.coordinator = max_id
#             print(f'{max_id} elected as coordinator')
#         next = nodes[(nodes.index(self)+1)%len(nodes)]
#         self.start_ring(next)

#     def start_ring(self,nodes):
#         if self.coordinator is None:
#             print(f"{self.id} initiated the election")
#             self.ring(nodes)

    

# nodes = [Node(1), Node(2), Node(3)]

# for node in nodes:
#     node.start_ring(nodes)

class Node:
    def __init__(self, node_id):
        self.id = node_id
        self.coordinator = None

    def ring(self, nodes):
        print(f'{self.id} sent a message')
        max_id = max(node.id for node in nodes)
        # print(max_id)
        if self.id == max_id:
            self.coordinator = self.id
            print(f'{self.id} elected as coordinator')
        next_node = nodes[(nodes.index(self) + 1) % len(nodes)]
        # print(next_node.id)
        next_node.start_ring(nodes)

    def start_ring(self, nodes):
        if self.coordinator is None:
            print(f"{self.id} initiated the election")
            self.ring(nodes)

nodes = [Node(1), Node(2), Node(3)]

for node in nodes:
    node.start_ring(nodes)
