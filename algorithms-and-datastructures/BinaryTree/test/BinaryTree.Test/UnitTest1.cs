using System;
using BinaryTree.App;
using Xunit;

namespace BinaryTree.Test
{
    public class UnitTest1
    {
        [Fact]
        public void AddingElements_ContainsThoseElements()
        {
            var tree = new BinaryTree<int>();
            tree.Add(2);
            tree.Add(5);
            tree.Add(1);
            
            Assert.True(tree.Contains(2));
            Assert.True(tree.Contains(5));
            Assert.True(tree.Contains(1));
            
            Assert.False(tree.Contains(0));
        }
    }
}
