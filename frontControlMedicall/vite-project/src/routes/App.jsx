import { BrowserRouter, Route, Routes } from "react-router-dom"
import { MenuNav } from "../components/MenuNav"
import {HomePage} from "../pages/HomePage"
import {ContactPage} from "../pages/ContactPage"
import { NotFound } from "../pages/NotFound"
import { AgendaPage } from "../pages/AgendaPage"
//import { AgendaDetalle } from "../pages/AgendaDetalle"
import { AgendaForm } from "../pages/AgendaForm"
import { AgendaCitasPage } from "../pages/AgendaCitasPage"
import { CitasAgendaPage } from "../pages/CitasAgendaPage"

function App() {

  return (
    <div>
      <BrowserRouter>
      <MenuNav/>
      <Routes>
        <Route path="/" element ={<HomePage/>}/>
        <Route path="/contacto" element ={<ContactPage/>}/>
        <Route path="/agenda" element={<AgendaPage/>}/>
        <Route path="/agenda/:id" element={<AgendaForm/>}/>
        <Route path="/agenda/form" element={<AgendaForm/>}/>
        <Route path="/agenda-citas" element ={<AgendaCitasPage/>}/>
        <Route path="/agenda/citas/:id" element ={<CitasAgendaPage/>}/>
        <Route path="*" element ={<NotFound/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
