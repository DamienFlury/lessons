using System;

namespace BinaryTree.App
{
    public class Node<T> where T: IComparable<T>
    {
        public Node(T value)
        {
            Value = value;
        }
        public T Value { get; }
        public  Node<T> Left { get; set; }
        public Node<T> Right { get; set; }


    }
}