using System;

namespace BinaryTree.App
{
    public class BinaryTree<T> where T : IComparable<T>
    {
        public Node<T> Root { get; set; }

        private static Node<T> AddRecursive(Node<T> current, T value)
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
            }

            return current;
        }

        public void Add(T value)
        {
            Root = AddRecursive(Root, value);
        }

        private static bool ContainsRecursive(Node<T> current, T value)
        {
            if (current == null)
            {
                return false;
            }

            if (value.CompareTo(current.Value) == 0)
            {
                return true;
            }

            return value.CompareTo(current.Value) == -1
                ? ContainsRecursive(current.Left, value)
                : ContainsRecursive(current.Right, value);
        }

        public bool Contains(T value) => ContainsRecursive(Root, value);

        private static Node<T> DeleteRecursive(Node<T> current, T value)
        {
            if (current == null) return null;
            switch (value.CompareTo(current.Value))
            {
                case 0:
                    if (current.Left == null && current.Right == null) return null;
                    if (current.Left == null) return current.Right;
                    if (current.Right == null) return current.Left;
                    return null;
                case -1:
                    current.Left = DeleteRecursive(current.Left, value);
                    return current;
                case 1:
                    current.Right = DeleteRecursive(current.Right, value);
                    return current;
                default:
                    return current;
            }
        }
    }
}