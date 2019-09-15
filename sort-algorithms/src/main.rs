
// Damien Flury
// 5ia17b
// 5. September 2019

fn main() {
    let mut array = [3, 2, 5, 7, 4, 1, 50, 32, 5, 10];
    println!("Sortieren mit eigenem Algorithmus");
    println!("---------------------------------");
    println!("10 Werte: {:?}", array);
    let sorted = Algorithms::selection_sort(&mut array);
    println!("Sortiert: {:?}", sorted);
}

struct Algorithms {
}

impl Algorithms {
    fn sort<T: PartialOrd>(array: &mut [T]) -> &[T] {
        let length = array.len();
        for i in (0..length - 1).rev() {
            for j in i..length - 1 {
                if array[j] > array[j + 1] {
                    array.swap(j, j + 1);
                }
            }
        }
        array
    }

    fn selection_sort<T: PartialOrd + std::fmt::Debug>(array: &mut [T]) -> &[T] {
        for i in 0..array.len() {
            let lowest_index = Self::get_lowest_index(&array[i..array.len()]);
            println!("{}", lowest_index);
            array.swap(i, i + lowest_index);
        }
        array
    }

    fn get_lowest_index<T: PartialOrd + std::fmt::Debug>(slice: &[T]) -> usize {
        println!("{:?}", slice);
        // slice.iter().skip(1).enumerate().fold((0, &slice[0]), |acc, (index, current)| if current > acc.1 {
        //     (index, current)
        // } else {
        //     acc
        // }).0
        let mut min = &slice[0];
        let mut min_index = 0;

        for (index, item) in slice.iter().enumerate() {
            if item < min {
                min = item;
                min_index = index;
            }
        }
        min_index
    }
}