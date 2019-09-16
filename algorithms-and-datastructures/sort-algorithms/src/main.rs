
// Damien Flury
// 5ia17b
// 5. September 2019

fn main() {
    let mut array = [3, 2, 5, 7, 4, 1, 50, 32, 5, 10];
    println!("Sortieren mit eigenem Algorithmus");
    println!("---------------------------------");
    println!("10 Werte: {:?}", array);
    array.insertion_sort();
    println!("Sortiert: {:?}", array);
}


trait SortAlgorithms {
    fn bubble_sort(&mut self) -> &Self;
    fn selection_sort(&mut self) -> &Self;
    fn insertion_sort(&mut self) -> &Self;
}

impl<T: PartialOrd> SortAlgorithms for [T] {
    fn bubble_sort(&mut self) -> &Self {
        let length = self.len();
        for i in (0..length - 1).rev() {
            for j in i..length - 1 {
                if self[j] > self[j + 1] {
                    self.swap(j, j + 1);
                }
            }
        }
        self
    }

    fn selection_sort(&mut self) -> &Self {
        for i in 0..self.len() {
            let lowest_index = get_lowest_index(&self[i..self.len()]);
            self.swap(i, i + lowest_index);
        }
        self
    }

    fn insertion_sort(&mut self) -> &Self {
        for i in 0..self.len() {
            for j in (0..i).rev() {
                if self[j] >= self[j + 1] {
                    self.swap(j, j + 1);
                }
            }
        }
        self
    }
}

fn get_lowest_index<T: PartialOrd>(slice: &[T]) -> usize {
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
