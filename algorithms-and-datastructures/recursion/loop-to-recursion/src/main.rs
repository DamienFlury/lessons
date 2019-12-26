fn main() {
    println!("index: {}", find(&[1, 16, 5, 6], 7).unwrap());
}

fn add(n: u32) -> u32 {
    (1..n).fold(0, |acc, current| acc + current)
}

fn add_recursive(n: u32) -> u32 {
    if n == 1 {
        return 1;
    }
    n + add_recursive(n - 1)
}

fn find<T: PartialEq>(array: &[T], x: T) -> Option<usize> {
    for (index, item) in array.iter().enumerate() {
        if *item == x {
            return Some(index);
        }
    }
    return None;
}