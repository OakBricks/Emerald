// var interval = 15 * 1000; // ms
// var expectedTime = Date.now() + interval;
// var timeRemaining = interval / 1000
// var intervalID

// function updateTimer() {
//    timeRemaining = timeRemaining - 1;
// //   console.log(timeRemaining);
//    document.getElementById("windowCloseCountdown").innerHTML = `Window will close in ${timeRemaining} seconds`;
//    if (timeRemaining < 1) {
//       clearInterval(intervalID);
//    }
// }
// intervalID = setInterval(updateTimer, 1000);


// setTimeout(step, interval);
// function step() {
//     var nowSubByExpectedTime = Date.now() - expectedTime;

//     if (nowSubByExpectedTime > interval) {
//         window.close();
//     }
//     window.close();
//     expectedTime += interval;
//     setTimeout(step, Math.max(0, interval - nowSubByExpectedTime));
// }