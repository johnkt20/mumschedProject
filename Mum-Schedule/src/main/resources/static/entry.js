window.onload = function () {
    //document.querySelector('form').addEventListener('submit', addProduct);
    let btnadd= document.getElementById("createentry_btn");
    //let btndelet=document.getElementById(" deletebtn");

    // for deleting course
    let elements;


    // btndelet.onclick=delteCourse;
    btnadd.onclick=addEntry;

}

function addEntry(e) {
    alert("EntryAdding");
   let entry_type;
    let entry_name = document.getElementById('entry_type').value;
    let fpp_number = document.getElementById("fpp_number").value;
    let mpp_number=document.getElementById("mpp_number").value;
    let start_date=document.getElementById("start_date").value;
    let end_date=document.getElementById("end_date").value;

        entry_type=entry_name;

   let date1= new Date(start_date);
   let date2= new Date( end_date);
       let entry=  {entryName: entry_name, fppNumber: fpp_number ,mppNumber:mpp_number,entryType:entry_type,startDate:formatDate(date1),
            endDate:formatDate(date2)};

    alert("entry_name:"+entry_name+"entry_startdate:"+formatDate(date1)+"entry_enddate"+formatDate(date2)+"fpp"+fpp_number+"mpp"+mpp_number);

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



    fetch('addentry', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(entry),
    })
        .then(response => response.json())
        .then(data => addingentry(data))
        .catch((error) => {
            console.error('Error:', error);
        });

    //e.target.reset();
   // e.preventDefault();
}

function addingentry(data) {
    alert("courseAddinggg...."+data.entryName+""+data.FPPNum);

    let entry = {entryName: data.entryName, fppNumber: data.fppNumber, mppNumber: data.mppNumber,startDate:data.startDate,endDate:data.endDate};

    let tr = document.createElement('tr');
    tr.id="row"+data.entryName;
    let btn1 = document.getElementsByClassName("clone_button").item(0);
    let btn11=btn1.cloneNode(true);

    btn11.id=data.entryName;
    btn11.value="Edit";
    btn11.className="editentry";
    btn11.addEventListener("click",function(event){editForm(this)});

    let btn2 = document.getElementsByClassName("clone_button").item(0);
    let bt22=btn2.cloneNode(true);
    //bt22.style.visibility="visible"
    bt22.id=data.id+1;
    bt22.className="deleteentry";
    bt22.addEventListener("click",function(event){delete_entry_in_row(this)});
    bt22.value="Delete";
    //btn2.id=""+data.id;
    // btn2.innerHTML = "Delete";
    // btn2.className = "deletecourse";



    let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    for (let key in entry) {

        let td = document.createElement('td');


        td.innerText = entry[key];

        tr.append(td);


    }
    td1.appendChild(btn11);
    td2.appendChild(bt22);
    tr.append(td1);
    tr.append(td2);
    document.querySelector("#entry_table").append(tr);


}

var deleteEntry_name;
function delete_entry_in_row(e){
    // e.stopImmediatePropagation();
    /*
    var ii = e.parentNode.parentNode.rowIndex;
    alert("idd"+e.id);
    let courseIdd=e.id;
    document.getElementById("course_table").deleteRow(ii);

    delteCourse(courseIdd);
    */

    var kk = e.parentNode.parentNode.rowIndex;
    deleteEntry_name= document.getElementById("entry_table").rows[kk].cells[0].innerHTML;
    //deletefrom front
    document.getElementById("entry_table").deleteRow(kk);
    alert("courseId"+deleteEntry_name);

    //e.preventDefault();
    delteEntry(deleteEntry_name);


}


function delteEntry(deleteEntry_name){
    console.log("deletebuttonclicked");
    //let id=document.getElementById("courseId").value;
    let entry_name=deleteEntry_name;
    let entry_namee = {entryName:entry_name,entryNumber: null, mppNumber: null};
//dfd
    fetch('deleteentry', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify( entry_namee),
    })
        .then(response => response.json())
        .then(data => entryDeleting(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
    // e.preventDefault();
}


function entryDeleting(data){
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









