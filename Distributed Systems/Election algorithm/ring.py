class Node:
    def __init__(self, id):
        self.id = id
        self.coordinator = None

    def initiate_ring_election(self, nodes):
        print(f"Node {self.id} initiates Ring election")
        max_id = max(node.id for node in nodes)  # Compare node IDs
        if self.id == max_id:
            self.coordinator = self.id
            print(f"Node {self.id} becomes the coordinator.")
            return
        next_node = nodes[(nodes.index(self) + 1) % len(nodes)]
        next_node.start_ring_election(nodes)

    def start_ring_election(self, nodes):
        if self.coordinator is None:
            print(f"Node {self.id} passes the election message.")
            self.initiate_ring_election(nodes)


nodes = [Node(1), Node(2), Node(3)]

for node in nodes:
    node.start_ring_election(nodes)