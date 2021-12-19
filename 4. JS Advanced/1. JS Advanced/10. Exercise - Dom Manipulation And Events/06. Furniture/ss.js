const  sharePersonalInfo  =   function (...activities)  {  
    let  info  =  `Hello, my name is ${this.name}.\n` + `I'm a ${this.profession}.\n`;  
    info  +=  activities.reduce((acc,  curr)  =>  { 
            let  el   =  `--- ${curr}\n`;
            return  acc  +  el;  
        },  
        "My hobbies are:\n").trim();  
    return  info;
}
const  firstPerson  =   {  name:   "Peter",  profession:   "Fisherman"  };
console.log(sharePersonalInfo.call(firstPerson, 'biking', 'swimming', 'football'));