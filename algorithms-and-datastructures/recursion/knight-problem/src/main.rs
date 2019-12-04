fn main() {
    let mut board = vec![vec![0; 8]; 8];
    knight_problem(&mut board, 0, 0, 1);
    to_string(board);
}

fn knight_problem(board: &mut Vec<Vec<u32>>, x: i32, y: i32, level: u32) -> bool {
    println!("{}", level);
    board[y as usize][x as usize] = level;
    if level == 63 {
        return true;
    }
    for i in (-2 as i32)..=2 {
        for j in (-2 as i32)..=2 {
            if i == j || i == -j || i == 0 || j == 0 {
                continue;
            }
            if y + i >= 0
                && y + i < 8
                && x + j >= 0
                && x + j < 8
                && board[(y + i) as usize][(x + j) as usize] == 0
            {
                if knight_problem(board, x + j, y + i, level + 1) {
                    return true;
                }
            }
        }
    }
    board[y as usize][x as usize] = 0;
    false
}

fn to_string(board: Vec<Vec<u32>>) {
    for i in board {
        for j in i {
            if(i / 10 == 1) {
                print!("{}  ", j);
            } else {
                print!("{} ", j);
            }
        }
        println!();
    }
}
