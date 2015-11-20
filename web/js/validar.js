/* 
 *Funciones en javaScript
 * crear una función que solo permita
 * al usuario ingresar numeros
 *1. Definir la función   
 */
function numeros(e){
 /*es un parámetro
  * de entrada
    **/    
   tecla=(document.all)?e.keyCode:e.which;
   if(tecla==8)return true;
   /* corresponde a la tecla de 
    * retroceso para borrar*/
   if(tecla==44)return true;
   /* corresponde a una coma(,) 
    * en el caso de decimales
    * */
   if(tecla==48)return true;//0
   if(tecla==49)return true;//1
   if(tecla==50)return true;//2
   if(tecla==51)return true;//3
   if(tecla==52)return true;//4
   if(tecla==53)return true;//5
   if(tecla==54)return true;//6
   if(tecla==55)return true;//7
   if(tecla==56)return true;//8
   if(tecla==57)return true;//9
  
    patron=/1/;
   te=String.fromCharCode(tecla);
   return patron.test(te);
}//fin de la función 
/*
 * permitir solamente letras
 * y algunos carácteres especiales
 * */
function sololetras(e){
 key=e.KeyCode||e.which;
 tecla=String.fromCharCode(key).toLocaleLowerCase();
 letras="áéíóabcdefghijklmnñopqrstuvwxyz ";
 especiales[8,37,39,46];
 tecla_especial =false;
 for(var i in especiales){
     if(key==especiales[i]){
        tecla_especial= true;
        break;
        
         
     }//fin si
     
 }//fin for
 if(letras.indexOf(tecla)==-1&&!tecla_especial){
     return false;
  }//fin si       
}// fin sololetras

