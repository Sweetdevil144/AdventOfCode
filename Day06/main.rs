fn main() {
    //
    const time: [i64;4] = [49, 87, 78, 95];
    const distance: [i64;4] = [356, 1378, 1502, 1882];
    let mut p:i64 = 1;
    for i in 0..4 {
        p*=partOne(time[i],distance[i]);
    }
    println!("{}",p);
    println!("{}",partOne(49877895, 356137815021882));
}

fn partOne(time: i64, distance: i64) -> i64 {
    let mut c = 0;
    let mut i = 0;
    while i < time {
        let x = i*(time-i);
        if x > distance {
            c += 1;
        }
        i=i+1
    }
    return c;
}