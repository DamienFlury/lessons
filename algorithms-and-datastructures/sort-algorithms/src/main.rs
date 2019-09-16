
// Damien Flury
// 5ia17b
// 5. September 2019

mod sort_algorithms;
mod collection_generators;

trait SortAlgorithms {
    fn bubble_sort(&mut self) -> &Self;
    fn selection_sort(&mut self) -> &Self;
    fn insertion_sort(&mut self) -> &Self;
}

impl <T: PartialOrd> SortAlgorithms for [T] {
    fn bubble_sort(&mut self) -> &Self {
        sort_algorithms::bubble_sort(self)
    }
    fn selection_sort(&mut self) -> &Self {
        sort_algorithms::selection_sort(self)
    }
    fn insertion_sort(&mut self) -> &Self {
        sort_algorithms::insertion_sort(self)
    }
}

fn main() {
    let mut array = collection_generators::get_random_array(10);
    println!("Sortieren mit eigenem Algorithmus");
    println!("---------------------------------");
    println!("10 Werte: {:?}", array);
    array.selection_sort();
    println!("Sortiert: {:?}", array);
}


