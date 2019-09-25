extern crate rand;
use rand::Rng;

pub fn get_random_array(amount: i32) -> Vec<i32> {
  let mut rng = rand::thread_rng();
  (0..amount).map(|_| rng.gen_range(1, 250)).collect()
}

pub fn get_sorted_array(amount: i32) -> Vec<i32> {
  (0..amount).collect()
}

pub fn get_nearly_sorted(amount: i32) -> Vec<i32> {
  let mut rng = rand::thread_rng();
  (0..amount).map(|item| if rng.gen_range(0, 3) == 0 {
    item + (rng.gen_range(0, 200) as i32) - 100 
  } else {
    item
  }).collect()
}

pub fn get_reversed_array(amount: i32) -> Vec<i32> {
  (0..amount).rev().collect()
}