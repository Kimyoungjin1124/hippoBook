const remainingMin = document.getElementById("remaining__min");
const remainingSec = document.getElementById("remaining__sec");
const completeBtn = document.getElementById("complete");

let time = 180;
const takeTarget = () => {
    setInterval(function (){
        if(time > 0) {
            time = time - 1;

            let min = Math.floor(time / 60);
            let sec = String(time % 60).padStart(2, "0");
            remainingMin.innerText = min;
            remainingSec.innerText = sec;
        } else {
            completeBtn.disabled = true;
        }
    }, 1000);
}