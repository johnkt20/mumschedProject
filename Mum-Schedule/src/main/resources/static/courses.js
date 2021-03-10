window.onload = function () {
    //document.querySelector('form').addEventListener('submit', addProduct);
    let btnadd= document.getElementById("createcourse_btn");
    //let btndelet=document.getElementById(" deletebtn");

    // for deleting course
    let elements;


   // btndelet.onclick=delteCourse;
      btnadd.onclick=addCourse;

}

function addCourse(e) {
//
    let courseCode = document.getElementById('course_codee').value;
    let courseName = document.getElementById('course_namee').value;
    let courseLevel=document.getElementById("course_level").value;
    let courseCredit=document.getElementById("course_credit").value;
    let maxStudents=document.getElementById("course_max_students").value;
    var course=  {courseCode: courseCode, courseName: courseName,level:courseLevel,credit:courseCredit, maxStudent:maxStudents};
    //if(document.getElementById("course_prerequisites").value===null)





   // let prereq=document.getElementById("course_prerequisites").value;



    alert("course:"+course);
    fetch('addcourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(course),
    })
        .then(response => response.json())
        .then(data => addingcourse(data))
        .catch((error) => {
            console.error('Error:', error);
        });

    //e.target.reset();
    e.preventDefault();
}

function addingcourse(data) {
    alert("courseAddinggg...."+data.id+""+data.courseName);

    if(data.prerequisites==null){
        data.prerequisites="null";
    }

    let course = {Id: data.id, courseCode: data.courseCode, courseName: data.courseName,level:data.level,credit:data.credit,maxStudent:data.maxStudent,prerequisites:data.prerequisites};

    let tr = document.createElement('tr');
    tr.id="row"+data.id;
    let btn1 = document.getElementsByClassName("clone_button").item(0);
    let btn11=btn1.cloneNode(true);

        btn11.id=data.id;
        btn11.value="Edit";
        btn11.className="editcourse";
        btn11.addEventListener("click",function(event){editForm(this)});

    let btn2 = document.getElementsByClassName("clone_button").item(0);
    let bt22=btn2.cloneNode(true);
       //bt22.style.visibility="visible"
       bt22.id=data.id+1;
       bt22.className="deletecourse";
       bt22.addEventListener("click",function(event){delete_course_in_row(this)});
       bt22.value="Delete";
    //btn2.id=""+data.id;
   // btn2.innerHTML = "Delete";
   // btn2.className = "deletecourse";



   let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    for (let key in course) {

        let td = document.createElement('td');


        td.innerText = course[key];

        tr.append(td);


    }
    td1.appendChild(btn11);
    td2.appendChild(bt22);
    tr.append(td1);
    tr.append(td2);
    document.querySelector("#course_table").append(tr);


}

var deleteCourseId;
function delete_course_in_row(e){
    // e.stopImmediatePropagation();
    /*
    var ii = e.parentNode.parentNode.rowIndex;
    alert("idd"+e.id);
    let courseIdd=e.id;
    document.getElementById("course_table").deleteRow(ii);

    delteCourse(courseIdd);
    */

    var kk = e.parentNode.parentNode.rowIndex;
    deleteCourseId= document.getElementById("course_table").rows[kk].cells[0].innerHTML;
    //deletefrom front
    document.getElementById("course_table").deleteRow(kk);
    alert("courseId"+deleteCourseId);

    //e.preventDefault();
    delteCourse(deleteCourseId);


}


function delteCourse(courseIdd){
    console.log("deletebuttonclicked");
    //let id=document.getElementById("courseId").value;
    let id=courseIdd;
    let courseid = {id:id,courseCode: null, courseName: null};
//dfd
    fetch('deleteCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify( courseid ),
    })
        .then(response => response.json())
        .then(data => courseDeleting(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
   // e.preventDefault();
}


function courseDeleting(data){
    alert("course deleteing..");
}
























/*

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


*/


/// Delete Course from List
/*
    var course_Id;
    var deleteCoursee=function deletFromList() {
//alert("your in ajax");
        let productId={id:course_Id};
        console.log("product id"+ this.id);
        fetch('/deleteCourse', {
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

       alert("courseDeleted");

    }






/// functionalliyt to handle event from table and button
    let elements = document.getElementsByClassName("deletecourse");

    let myFunction = function(e) {
        // e.stopImmediatePropagation();
        let attribute = this.getAttribute("data-myattribute");
        //tst
        var kk = this.parentNode.parentNode.rowIndex;
        course_Id= document.getElementById("course_table").rows[kk].cells[0].innerHTML;
        //deletefrom front
        document.getElementById("course_table").deleteRow(kk);
        alert("Product removed from cart!!");

        //e.preventDefault();
        deleteCoursee();
    };

    for (let m = 0; m < elements.length; m++) {
        elements[m].addEventListener('click', myFunction, false);
    }



*/









