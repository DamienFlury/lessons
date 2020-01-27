struct Node<T>
where
    T: PartialOrd,
{
    value: T,
    left: Box<Option<Node<T>>>,
    right: Box<Option<Node<T>>>,
}

struct BinaryTree<T>
where
    T: PartialOrd,
{
    root: Node<T>,
}

fn add_recursive<T: PartialOrd>(optionalNode: Option<Node<T>>, value: T) -> Node<T> {
    match optionalNode {
        Some(node) => add_recursive(
            if value <= node.value {
                *node.left
            } else {
                *node.right
            },
            value,
        ),
        None => Node {
            value: value,
            left: Box::new(None),
            right: Box::new(None),
        },
    }
}

impl<T: PartialOrd> Node<T> {
    fn add(&self, value: T) {
        add_recursive(self, value);
    }
}

fn main() {
    println!("Hello, world!");
}
