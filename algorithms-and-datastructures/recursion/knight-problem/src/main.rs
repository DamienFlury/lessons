fn main() {
    let mut board = vec![vec![0; 8]; 8];
    knight_problem(&mut board, 0, 0, 0);
    println!("{:?}", board);
}

fn knight_problem(board: &mut Vec<Vec<u32>>, x: i32, y: i32, level: u32) {
    if level == 199 {
        return;
    }
    board[y as usize][x as usize] = level;
    for i in (-2 as i32)..=2 {
        for j in (-2 as i32)..=2 {
            if i == j || i == -j || i == 0 || j == 0 {
                continue;
            }
            if y + i >= 0 && 
                y + i < 8 && 
                x + j >= 0 && 
                x + j < 8 && 
                board[(y + i) as usize][(x + j) as usize] == 0 {
                knight_problem(board, x + j, y + i, level + 1);
            }
        }
    }
}