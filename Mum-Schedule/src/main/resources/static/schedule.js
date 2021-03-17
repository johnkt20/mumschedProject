window.onload = function () {
    //document.querySelector('form').addEventListener('submit', addProduct);
    let btnadd= document.getElementById("createsche_btn");
    //let btndelet=document.getElementById(" deletebtn");

    // for deleting course
    let elements;


    // btndelet.onclick=delteCourse;
    btnadd.onclick=addSche;

}

function addSche(e) {
    alert("EntryAdding");
    let entry_name=document.getElementById("entry_name").value;
    let sche_status=document.getElementById("sche_status").value;
    let entry={entryName:entry_name};


    let sche=  {entry:entry,scheduleStatus:sche_status};


    alert("entry_name:"+entry_name);



    fetch('addschedule', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(sche),
    })
        .then(response => response.json())
        .then(data => addingsche(data))
        .catch((error) => {
            console.error('Error:', error);
        });

    //e.target.reset();
    // e.preventDefault();
}

function addingsche(data) {
    alert("sectionAddinggg...."+data.entry.entryName+"");
    let entry_name=data.entry.entryName

    let sche = {entryName:data.entry.entryName,scheduleStatus:data.scheduleStatus};

    let tr = document.createElement('tr');
    tr.id="row"+entry_name;
    let btn1 = document.getElementsByClassName("clone_button").item(0);
    let btn11=btn1.cloneNode(true);

    btn11.id=entry_name;
    btn11.value="Edit";
    btn11.className="editsection";
    btn11.addEventListener("click",function(event){editForm(this)});

    let btn2 = document.getElementsByClassName("clone_button").item(0);
    let bt22=btn2.cloneNode(true);
    //bt22.style.visibility="visible"
    bt22.id=entry_name+1;
    bt22.className="deletesche";
    bt22.addEventListener("click",function(event){delete_sche_in_row(this)});
    bt22.value="Delete";

    let btn3= document.getElementsByClassName("clone_button").item(0);
    let btn33=btn3.cloneNode(true);
    btn33.id=entry_name+2;
    btn33.className="generatesche";
    btn33.addEventListener("click",function(event){generate_sche(this)});
    btn33.value="Gnerate Schedule";




    let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    let td3=document.createElement("td");
    for (let key in sche) {

        let td = document.createElement('td');


        td.innerText = sche[key];

        tr.append(td);


    }
    td1.appendChild(btn11);
    td2.appendChild(bt22);
    td3.appendChild(btn33);
    tr.append(td1);
    tr.append(td2);
    tr.append(td3);
    document.querySelector("#sche_table").append(tr);


}

var deletesche_byid;
function delete_sche_in_row(e){
    // e.stopImmediatePropagation();
    /*
    var ii = e.parentNode.parentNode.rowIndex;
    alert("idd"+e.id);
    let courseIdd=e.id;
    document.getElementById("course_table").deleteRow(ii);

    delteCourse(courseIdd);
    */

    var kk = e.parentNode.parentNode.rowIndex;
    deletesche_byid= document.getElementById("sche_table").rows[kk].cells[0].innerHTML;
    //deletefrom front
    document.getElementById("sche_table").deleteRow(kk);
    alert("scheName"+deletesche_byid);

    //e.preventDefault();
    delteSche(deletesche_byid);


}


function delteSche(deletesche_byid){
    console.log("deletebuttonclicked");
    //let id=document.getElementById("courseId").value;
    let sche_id=deletesche_byid;

    let sche_idd = { id:sche_id};
//dfd
    fetch('deleteschedule', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(sche_idd ),
    })
        .then(response => response.json())
        .then(data => scheDeleting(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
    // e.preventDefault();
}


function scheDeleting(data){
    alert("section deleteing..");
}




// GenerateSchedule
function generate_sche(e){
   let row_index=e.parentNode.parentNode.rowIndex;
    let sche_id=document.getElementById("sche_table").rows[row_index].cells[0].innerHTML;


    let scheid=  {id:sche_id};


    alert("entry_name:"+sche_id);



    fetch('generateschedule', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(scheid),
    })
        .then(response => response.json())
        .then(data => generatesche_1(data))
        .catch((error) => {
            console.error('Error:', error);
        });
}




function generatesche_1(data){
    alert("Schedule generated successfully");
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









