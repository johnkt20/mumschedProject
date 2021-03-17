window.onload = function () {

    //document.querySelector('form').addEventListener('submit', addProduct);
    let btnadd= document.getElementById("createfaculty_btn");
    //let btndelet=document.getElementById(" deletebtn");

    // for deleting course
    let elements;


    // btndelet.onclick=delteCourse;
    btnadd.onclick=addFaculty;

}

function addFaculty(e) {
//
    let firstName = document.getElementById('first_namee').value;
    let lastName = document.getElementById('last_namee').value;
    let email= document.getElementById('emaile').value;

    let faculty = {firstName: firstName, lastName: lastName,email:email};
    alert("faculty:"+faculty);
    fetch('addfaculty', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(faculty),
    })
        .then(response => response.json())
        .then(data => addingfaculty(data))
        .catch((error) => {
            console.error('Error:', error);
        });

    //e.target.reset();
    e.preventDefault();
}

function addingfaculty(data) {
    alert("studentAddinggg...."+data.id+""+data.firstName);
    let faculty = {Id: data.id, firstName: data.firstName, lastName: data.lastName,email:data.email};

    let tr = document.createElement('tr');
    tr.id="row"+data.id;
    let btn1 = document.getElementsByClassName("clone_btn").item(0);
    let btn11=btn1.cloneNode(true);
    btn11.id=data.id;
    btn11.value="Edit";
    btn11.className="editfaculty_111";
    btn11.addEventListener("click",function(event){editFaculty(this)});

    let btn2 = document.getElementsByClassName("clone_btn").item(0);
    let bt22=btn2.cloneNode(true);
    bt22.value="Delete";
    bt22.id=data.id+1;
    bt22.className="deletefaculty";
    bt22.addEventListener("click",function(event){delete_faculty_in_row(this)});



    let td11 = document.createElement('td');
    let td2 = document.createElement('td');
    for (let key in faculty) {

        let td = document.createElement('td');


        td.innerText = faculty[key];

        tr.append(td);


    }
    td11.appendChild(btn11);
    td2.appendChild(bt22);
    tr.append(td11);
    tr.append(td2);
    document.querySelector("#faculty_table").append(tr);


}

var deleteFacultyId;
function delete_faculty_in_row(e){
    // e.stopImmediatePropagation();
    /*
    var ii = e.parentNode.parentNode.rowIndex;
    alert("idd"+e.id);
    let courseIdd=e.id;
    document.getElementById("course_table").deleteRow(ii);

    delteCourse(courseIdd);
    */

    var kk = e.parentNode.parentNode.rowIndex;
    deleteFacultyId= document.getElementById("faculty_table").rows[kk].cells[0].innerHTML;
    //deletefrom front
    document.getElementById("faculty_table").deleteRow(kk);
    alert("cstudentId"+deleteFacultyId);

    //e.preventDefault();
    delteFaculty(deleteFacultyId);


}


function delteFaculty(deleteFacultyId){
    console.log("deletebuttonclicked");
    //let id=document.getElementById("studentId").value;
    let id=deleteFacultyId;
    let facultyIdd = {id:id,firstName: null, lastName: null};

    fetch('deletefaculty', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify( facultyIdd ),
    })
        .then(response => response.json())
        .then(data => facultyDeleting(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
    // e.preventDefault();
}


function facultyDeleting(data){
    alert("student deleteing..");
}




