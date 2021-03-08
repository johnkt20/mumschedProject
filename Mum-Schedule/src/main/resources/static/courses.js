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
    alert("courseAdding....");
    let course={Id:data.id,courseCode:data.courseCode,courseName:data.courseName};

    let tr = document.createElement('tr');
    var btn1 = document.createElement("BUTTON");
    btn1.innerHTML = "EDIT";
    btn1.className="editcourse";
    var btn2 = document.createElement("BUTTON");
    btn2.innerHTML = "DELETE";
    btn2.className="deletecourse";




    for (let key in course) {

        let td = document.createElement('td');
        let td1=document.createElement('td');
        let td2=document.createElement('td');

        td.innerText = course[key];
        td1.appendChild(btn1);
        td2.appendChild(btn2);
        tr.append(td);
        tr.append(td1);
        tr.append(td2);

    }


    document.querySelector("#tableProducts").append(tr);


}






/// Delete product

function delteCourse(e){
    console.log("deletebuttonclicked");
    let id=document.getElementById("courseId").value;

    let courseid = {id:id,courseCode: null, courseName: null};

    fetch('deleteCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify( courseid ),
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


    <!-- pop up -->
    let openform= document.getElementById("openfrm");
    openform.onclick=openForm;

    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }


    // Edit and delete course


/// Delete Product from Cart

    var deleteCourseID;
    var deletCourse=function deletFromCart() {
//alert("your in ajax");
        let courseId={id:deleteCourseID};
        console.log("product id"+ this.id);
        fetch('/deletefromcart.jsp', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(productId),
        })
            .then(response => response.json())
            .then(data => processData3(data))
            .catch((error) => {
                console.error('Error:', error);
            });
        //e.target.reset();
        //e.preventDefault();
    }

    function processData3(data) {

        alert("course deleted..");

    }






/// functionalliyt to handle event from table and button
    let elements = document.getElementsByClassName("btn1");

    let myFunction = function(e) {
        // e.stopImmediatePropagation();
        let attribute = this.getAttribute("data-myattribute");
        //tst
        var kk = this.parentNode.parentNode.rowIndex;
        deleteCourseID= document.getElementById("cartlist").rows[kk].cells[0].innerHTML;
        //deletefrom front
        document.getElementById("cartlist").deleteRow(kk);
        alert("Product removed from cart!!");

        //e.preventDefault();
        deletCourse();
    };






}
