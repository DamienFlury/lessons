using System;

namespace BinaryTree.App
{
    public class BinaryTree<T> where T: IComparable<T>
    {
        public BinaryTree(T rootValue)
        {
            Root = new Node<T>(rootValue);
        }
        public Node<T> Root { get; set; }

        public Node<T> AddRecursive(Node<T> current, T value)
        {
            if (current == null)
            {
                return new Node<T>(value);
            }

            switch (value.CompareTo(current.Value))
            {
                case -1:
                    current.Left = AddRecursive(current.Left, value);
                    break;
                case 1:
                    current.Right = AddRecursive(current.Right, value);
                    break;
                default:
                    return current;
            }

            return current;
        }

        public bool ContainsRecursive(Node<T> current, T value)
        {
            if (current.Value.CompareTo(value) == 0) return true;
            if (current.Value.CompareTo(value) == -1)
            {
                return ContainsRecursive(current.Left, value);
            }
            else
            {
                return ContainsRecursive(current.Right, value):
            }

            return value.CompareTo(current.Value) switch
            {
                0 => true,
                -1 => ContainsRecursive(current.Left, value),
                1 => ContainsRecursive(current.Right, value)
            };
        }
    }
}