window.onload = function () {
    //document.querySelector('form').addEventListener('submit', addProduct);
    let btnadd= document.getElementById("createsection_btn");
    //let btndelet=document.getElementById(" deletebtn");

    // for deleting course
    let elements;


    // btndelet.onclick=delteCourse;
    btnadd.onclick=addSection;

}

function addSection(e) {
    alert("EntryAdding");
    let section_name=document.getElementById("section_name").value;
    let classRoom_name = document.getElementById('classRoom_name').value;
    let capacity=document.getElementById("capacity").value;
    let start_date=document.getElementById("start_date").value;
    let end_date=document.getElementById("end_date").value;
    let course_name=document.getElementById("course_name").value;
    let block_name=document.getElementById("block_name").value;

    let course={courseName:course_name,courseCode:null};
    let block={blockName:block_name,entryName:null};


    let date1= new Date(start_date);
    let date2= new Date( end_date);
    let section=  {sectionName:section_name,classRoom: classRoom_name, capacity: capacity ,
        startDate:formatDate(date1),
        endDate:formatDate(date2),course:course,block:block};


    alert("section_name:"+section_name+"section_startdate:"+formatDate(date1)+"section_enddate"+formatDate(date2)+"capacity"+capacity+"course"+course_name+"block"+block_name);

    function formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;

        return [year, month, day].join('-');
    }

alert("stringfy"+JSON.stringify(section));

    fetch('addsection', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(section),
    })
        .then(response => response.json())
        .then(data => addingsection(data))
        .catch((error) => {
            console.error('Error:', error);
        });

    //e.target.reset();
    // e.preventDefault();
}

function addingsection(data) {
    alert("sectionAddinggg...."+data.sectionName+"");
    let course_name=data.course.courseName;
    let block_name =data.block.blockName;
    let section = {sectionName:data.sectionName,classRoom: data.classRoom, capacity: data.capacity,startDate:data.startDate,endDate:data.endDate,course_name,block_name};

    let tr = document.createElement('tr');
    tr.id="row"+data.sectionName;
    let btn1 = document.getElementsByClassName("clone_button").item(0);
    let btn11=btn1.cloneNode(true);

    btn11.id=data.sectionName;
    btn11.value="Edit";
    btn11.className="editsection";
    btn11.addEventListener("click",function(event){editForm(this)});

    let btn2 = document.getElementsByClassName("clone_button").item(0);
    let bt22=btn2.cloneNode(true);
    //bt22.style.visibility="visible"
    bt22.id=data.sectionName+1;
    bt22.className="deletesection";
    bt22.addEventListener("click",function(event){delete_section_in_row(this)});
    bt22.value="Delete";
    //btn2.id=""+data.id;
    // btn2.innerHTML = "Delete";
    // btn2.className = "deletecourse";



    let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    for (let key in section) {

        let td = document.createElement('td');


        td.innerText = section[key];

        tr.append(td);


    }
    td1.appendChild(btn11);
    td2.appendChild(bt22);
    tr.append(td1);
    tr.append(td2);
    document.querySelector("#section_table").append(tr);


}

var deleteSection_byClassRoomName;
function delete_section_in_row(e){
    // e.stopImmediatePropagation();
    /*
    var ii = e.parentNode.parentNode.rowIndex;
    alert("idd"+e.id);
    let courseIdd=e.id;
    document.getElementById("course_table").deleteRow(ii);

    delteCourse(courseIdd);
    */

    var kk = e.parentNode.parentNode.rowIndex;
    deleteSection_byClassRoomName= document.getElementById("section_table").rows[kk].cells[1].innerHTML;
    //deletefrom front
    document.getElementById("section_table").deleteRow(kk);
    alert("sectionName"+deleteSection_byClassRoomName);

    //e.preventDefault();
    delteSection(deleteSection_byClassRoomName);


}


function delteSection(deleteSection_byClassRoomName){
    console.log("deletebuttonclicked");
    //let id=document.getElementById("courseId").value;
    let classRoom_name=deleteSection_byClassRoomName;

    let section_namee = {sectionName:null,classRoom:classRoom_name,capacity: null};
//dfd
    fetch('deletesection', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify( section_namee),
    })
        .then(response => response.json())
        .then(data => sectionDeleting(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
    // e.preventDefault();
}


function sectionDeleting(data){
    alert("section deleteing..");
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









