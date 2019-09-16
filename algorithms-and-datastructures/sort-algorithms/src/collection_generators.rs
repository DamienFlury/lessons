extern crate rand;
use rand::Rng;

pub fn get_random_array(amount: usize) -> Vec<u32> {
  let mut rng = rand::thread_rng();
  (0..amount).map(|_| rng.gen_range(1, 250)).collect()
}