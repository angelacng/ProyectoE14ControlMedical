import { BrowserRouter, Route, Routes } from "react-router-dom"
import { MenuNav } from "../components/MenuNav"
import { HomePage } from "../pages/HomePage"
import { ContactPage } from "../pages/ContactPage"
import { NotFound } from "../pages/NotFound"
import { AgendaPage } from "../pages/AgendaPage"
import { AgendaForm } from "../pages/AgendaForm"
import { AgendaCitasPage } from "../pages/AgendaCitasPage"
import { CitasAgendaPage } from "../pages/CitasAgendaPage"
import { PacienteForm } from "../pages/PacienteForm"
import { PacientePage } from "../pages/PacientePage"
import { PacienteDetalle } from "../pages/PacienteDetalle"
import { useState } from "react"
import { Login } from "../pages/Login"
import { ProtectedRoute } from "../components/ProtectedRoute"

function App() {
 
  const [user, setUser] = useState(null);
  const login = () =>
  setUser({
    id: 1,
    name: "usuario1",
    permisos: ["analizar"],
    roles: ["admin"]
  });

const logout = () => setUser(null);




  return (
    <div >
      
      <BrowserRouter>

        <MenuNav />
        {
          
          user ? (
            
            <div ><button   onClick={logout}>Logout</button></div>
          ) : <div ><button onClick={login}>Login</button></div>
          
        }
    

        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/contacto" element={<ContactPage />} />
          <Route path="/agenda-citas" element={<AgendaCitasPage />} />
          <Route path="/agenda/citas/:id" element={<CitasAgendaPage />} />
          <Route path="*" element={<NotFound />} />
          <Route element={<ProtectedRoute isAllowed={!!user} />}>
            
            <Route path="/agenda/:id" element={<AgendaForm />} />
            <Route path="/agenda/form" element={<AgendaForm />} />
            <Route path="/pacientes" element={<PacientePage />} />
            <Route path="/pacientes/registrar" element={<PacienteForm />} />
            <Route path="/pacientes/:id" element={<PacienteDetalle />} />
          </Route>

          <Route path="/agenda" element={<ProtectedRoute
            redirectTo="/"
            isAllowed={!!user && user.roles.includes("admin")}
          >
            <AgendaPage />
          </ProtectedRoute>} />

        </Routes>
        
      </BrowserRouter>
    </div>
  )
}

export default App;

