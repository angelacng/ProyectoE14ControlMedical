import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { Button, Col, Container, FormCheck, FormControl, FormLabel, Row } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import { existsPacienteByNdocumento, findAgendaById, findPacienteByNdocumento, guardarAgenda } from "../server/Server";

function CitasAgendaPage() {

    const { id } = useParams();
    const [agenda, setAgenda] = useState({});
    const [horaRadio, sethoraRadio] = useState("");
    const [ndocumento, setNdocumento] = useState("");


    const [citas, setCitas] = useState([]);
    const navigate = useNavigate();


    const franjaHoraria = ["8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30"];
    const franjaHorariaPM = ["2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30"];
    let horariosOcupados = [];
    let pacientesAgendados = [];


    citas.map((cita) => {
        horariosOcupados.push(cita.hora)
        pacientesAgendados.push(cita.id_paciente)
    })



    function returnToAgendaCitas() {
        navigate("/agenda-citas");
    }


    useEffect(() => {
        findAgendaById(id).then(data => {
            setAgenda(data);
            setCitas(data.citas);
        });
    }, [id]);

    const handleSelect = (e) => {
        sethoraRadio(e.target.value);
    }


    const handleChange = (e) => {
        setNdocumento(e.target.value);
    };


    async function handleSubmit() {
        if (horaRadio !== "") {
            if (ndocumento !== "") {
                const resultado = await existsPacienteByNdocumento(ndocumento);
                if (resultado) {
                    const paciente = await findPacienteByNdocumento(ndocumento)
                    const consulta = pacientesAgendados.includes(paciente.id);
                    if (!consulta === true) {
                        agenda.citas.push({ hora: horaRadio, id_paciente: paciente.id });
                        delete agenda.nombremedico;
                        delete agenda.especialidad;
                        delete agenda.apellidomedico;
                        guardarAgenda(agenda);
                        alert("Se agendó la cita");
                        returnToAgendaCitas();
                    } else {
                        alert("El paciente ya agendó una cita");
                    }
                } else {
                    alert("Número de documento no válido");
                }
            } else {
                alert("Ingrese el número de documento del paciente")
            }
        } else {
            alert("Seleccione una hora")
        }
    }



    return (
        <Container className="my-3">
            <Row>
                <Col>
                    <h5> Fecha Cita:</h5>
                    <h5>{agenda.fecha}</h5>
                </Col>
                <Col>
                    <h5>Nombre del médico</h5>
                    <h5>{agenda.nombremedico} {agenda.apellidomedico}</h5>
                </Col>
                <Col>
                    <h5>Especialidad:</h5>
                    <h5>{agenda.especialidad}</h5>
                </Col>
            </Row>


            <Row className="my-5">
                <Col xs lg="3" >

                    <FormLabel>N° de identificación del paciente</FormLabel>
                    <FormControl

                        required
                        type="number"
                        onChange={handleChange}
                    />
                </Col>
                <Col xs lg="1" >

                </Col>
                <Col xs lg="2" >
                    Horarios Disponibles:
                </Col>
                <Col md="auto">
                    {
                        franjaHoraria.map((hora) => (
                            <FormCheck className="my-3"
                                key={hora}
                                label={hora + " AM"}
                                type="radio"
                                name="hora"
                                value={hora}
                                onChange={handleSelect}
                                disabled={(horariosOcupados.includes(hora)) ? true : false}

                            />
                        ))
                    }
                </Col>
                <Col md="auto">
                    {
                        franjaHorariaPM.map((hora) => (
                            <FormCheck className="my-3"
                                key={hora}
                                label={hora + " PM"}
                                type="radio"
                                name="hora"
                                value={hora}
                                onChange={handleSelect}
                                disabled={(horariosOcupados.includes(hora)) ? true : false}

                            />
                        ))
                    }
                </Col>

            </Row>
            <Row>
                <Col>
                    <Button variant="success" onClick={() => { handleSubmit() }}>Registrar Cita</Button>
                </Col>
                <Col>
                    <Button variant="primary" onClick={returnToAgendaCitas}>Regresar</Button>
                </Col>
            </Row>

        </Container>

    )
}
export { CitasAgendaPage }