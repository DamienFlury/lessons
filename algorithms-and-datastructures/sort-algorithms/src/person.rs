use std::cmp::{PartialEq, PartialOrd};

#[derive(PartialEq)]
pub struct Person {
    first_name: String,
    last_name: String,
}

impl PartialOrd for Person {

    fn partial_cmp(&self, rhs: &Self) -> Option<std::cmp::Ordering> {
        Some(self.first_name.cmp(&rhs.first_name))
    }

}