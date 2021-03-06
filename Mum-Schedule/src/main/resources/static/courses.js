window.onload = function () {
    //document.querySelector('form').addEventListener('submit', addProduct);
    let btnadd= document.getElementById("btnadd");
    let btndelet=document.getElementById("deletebtn");
    btndelet.onclick=delteCourse;
      btnadd.onclick=addCourse;
}

function addCourse(e) {

    let courseCode = document.getElementById('course_code').value;
    let courseName = document.getElementById('course_name').value;


    let course = {courseCode: courseCode, courseName: courseName};
    fetch('addcourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(course),
    })
        .then(response => response.json())
        .then(data => processData(data))
        .catch((error) => {
            console.error('Error:', error);
        });

    //e.target.reset();
    e.preventDefault();
}

function processData(data) {
    //alert("courseAdding....");
    let course={Id:data.Id,courseCode:data.courseCode,courseName:data.courseName};

    let tr = document.createElement('tr');
    for (let key in course) {

        let td = document.createElement('td');
        td.innerText = course[key];
        tr.append(td);
    }
    document.querySelector("#tableProducts").append(tr);


}





/// Delete product

function delteCourse(e){
    console.log("deletebuttonclicked");
    let id=document.getElementById("courseId").value;
    let courseId = {Id: id};
    fetch('deleteCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(courseId),
    })
        .then(response => response.json())
        .then(data => processData2(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
   // e.preventDefault();
}

function processData2(data) {

    let courseID;
    let table = document.getElementById("tableProducts");

    for(let key in data){
        courseID=data[key];
    }
    console.log("courseID"+courseID);
   console.log("cell value"+table.rows[1].cells[0].innerHTML);
    for (let i in table.rows) {
        let row = table.rows[i]
        console.log("insidetable");
        //iterate through rows
        //rows would be accessed using the "row" variable assigned in the for loop
        for (let j in row.cells) {
            let col = row.cells[j]
            if(col.innerHTML==courseID){
                console.log("insiderow");
               table.deleteRow(i);
            }
            //iterate through columns
            //columns would be accessed using the "col" variable assigned in the for loop
        }
    }



}
