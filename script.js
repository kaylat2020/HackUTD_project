const dragArea = document.querySelector('.drag-area');
const dragText = document.querySelector('.header')
const dragIcon = document.querySelector('.icon')


let button = document.querySelector('.button');
let input = document.querySelector('input');
let file;

button.onclick = () => {
    input.click();
};

//when in file browser
input.addEventListener('change', function() {
    file = this.files[0];
        dragArea.classList.add('.active')
    fileValidation();
})
// when file is inside drag area
dragArea.addEventListener('dragover', (event) => {
    event.preventDefault();
    dragText.textContent = 'Release to upload';
    dragArea.classList.add('active');
    //console.log('File is inside of the drag area');
});

// when file leaves the drag area
dragArea.addEventListener('dragleave', () => {
    dragText.textContent = 'Drag & drop';
    dragArea.classList.remove('active');
    //console.log('File left the drag area');
});

//when the file is dropped in the drag area
dragArea.addEventListener('drop', (event) => {
    event.preventDefault();
    dragText.textContent = 'File received';
    //only selects first file user uploads
    file = event.dataTransfer.files[-0];
    fileValidation();

    
});

function fileValidation() {
    let fileType = file.type;
    //console.log(fileType);

    let validExtensions = ['text/plain'];

    if(validExtensions.includes(fileType)) {
        let fileReader = new FileReader();
        dragIcon.textContent = '✅';

        fileReader.onload = () => {
            let fileURL = fileReader.result;
            //console.log(fileURL);
        let txtTag = `<img src ="success.png" alt = "Success">`; 
        };
        fileReader.readAsDataURL(file);
    } else {
        alert('This file is not a .txt file');
    }
    //TEST console.log('File has been dropped in the drag area');
}

//converts markdown to html file (in theory)
function fileConvert() {
    var converter = new showdown.Converter(),
    text = fileReader.readAsText(file),
    html = converter.makeHtml(text);
    //put html text into new html file, link w/ created.html

}
//displays in a web content window (also in theory)
function load_webpage() {
    document.getElementById("content").innerHTML='<object type="text/html" data="webpage.html"></object>';
}

function loadHtml(id, filename) {
    console.log(`div id: ${id}, filename: ${filename}`);

    let xhttp;
    let element = document.getElementById(id);
    let file = filename;

    if ( file ) {
        xhttp = new XMLHttRrequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4) {
                if (this.status == 200) {element.innerHTML = this.responseText;}
                if (this.status == 404) {element.innerHTML = "<h1>Page not found.</h1>";}
            }
        }
        xhttp.open("GET", `templates/${file}`, true); //initializes request
        xhttp.send(); //sends request
        return;
    }
}