
// Damien Flury
// 5ia17b
// 5. September 2019

mod sort_algorithms;
mod collection_generators;
mod person;

use collection_generators::*;
use std::time::{Instant};

trait SortAlgorithms {
    fn bubble_sort(&mut self);
    fn selection_sort(&mut self);
    fn insertion_sort(&mut self);
}

impl <T: PartialOrd> SortAlgorithms for [T] {
    fn bubble_sort(&mut self) {
        sort_algorithms::bubble_sort(self)
    }
    fn selection_sort(&mut self) {
        sort_algorithms::selection_sort(self)
    }
    fn insertion_sort(&mut self) {
        sort_algorithms::insertion_sort(self)
    }
}

fn print(algorithm: &str, array_type: &str) {
    let amount = 300000;
    let mut array = match array_type {
        "RANDOM" => get_random_array(amount),
        "SORTED" => get_sorted_array(amount),
        "NEARLY_SORTED" => get_nearly_sorted(amount),
        "REVERSED" => get_reversed_array(amount),
        _ => get_random_array(amount),
    };
    let now = Instant::now();
    match algorithm {
        "SELECTION" => array.selection_sort(),
        "BUBBLE" => array.bubble_sort(),
        "INSERTION" => array.insertion_sort(),
        _ => array.sort(),
    };
    println!("{} SORT (random): {}", algorithm, now.elapsed().as_millis());
}

fn main() {

    println!("Sortieren mit eigenem Algorithmus");
    println!("---------------------------------");
    // println!("10 Werte: {:?}", array);

    print("SELECTION", "RANDOM");
    // print("INSERTION", "SORTED");
    // print("BUBBLE", "RANDOM");
    // let now = Instant::now();
    // array.selection_sort();
    // println!("Selection Sort (random): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_random_array(amount);
    // let now = Instant::now();
    // array.bubble_sort();
    // println!("Bubble Sort (random): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_random_array(amount);
    // let now = Instant::now();
    // array.insertion_sort();
    // println!("Insertion Sort (random): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_sorted_array(amount);
    // let now = Instant::now();
    // array.selection_sort();
    // println!("Selection Sort (sorted): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_sorted_array(amount);
    // let now = Instant::now();
    // array.bubble_sort();
    // println!("Bubble Sort (sorted): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_sorted_array(amount);
    // let now = Instant::now();
    // array.insertion_sort();
    // println!("Insertion Sort (sorted): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_nearly_sorted(amount as i32);
    // let now = Instant::now();
    // array.selection_sort();
    // println!("Selection Sort (nearly sorted): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_nearly_sorted(amount as i32);
    // let now = Instant::now();
    // array.bubble_sort();
    // println!("Bubble Sort (nearly sorted): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_nearly_sorted(amount as i32);
    // let now = Instant::now();
    // array.insertion_sort();
    // println!("Insertion Sort (nearly sorted): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_reversed_array(amount);
    // let now = Instant::now();
    // array.selection_sort();
    // println!("Selection Sort (reversed): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_reversed_array(amount);
    // let now = Instant::now();
    // array.bubble_sort();
    // println!("Bubble Sort (reversed): {}", now.elapsed().as_millis());

    // let mut array = collection_generators::get_reversed_array(amount);
    // let now = Instant::now();
    // array.insertion_sort();
    // println!("Insertion Sort (reversed): {}", now.elapsed().as_millis());

    // println!("Sortiert: {:?}", array);
}


