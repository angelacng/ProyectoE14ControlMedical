import React from "react";
import { Container } from "react-bootstrap";
import { useParams } from "react-router-dom";

function AgendaDetalle(){
    const{id}=useParams();
    return(
       <Container>
        <h2>Detalle de la Agenda con id: {id}</h2>
       
       </Container>
    )
}
export{AgendaDetalle}