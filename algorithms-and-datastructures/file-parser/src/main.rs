use std::fs;

fn main() {
    let contents = fs::read_to_string("myfile.txt").unwrap();
    let vecs = parse(contents);
    println!("{:?}", vecs);
}

fn parse(input: String) -> Vec<Vec<i32>> {
    let lines = input.split('\n').skip(2).step_by(2);
    lines.map(|line|
        line.split(' ').map(|num_str| 
            num_str.parse::<i32>().unwrap())
        .collect())
    .collect()
}
