package com.Neteam.Movimientos.controller;

import com.Neteam.Movimientos.modelo.Empresa;
import com.Neteam.Movimientos.modelo.Movimiento;
import com.Neteam.Movimientos.modelo.Usuario;
import com.Neteam.Movimientos.service.EmpresaService;
import com.Neteam.Movimientos.service.MovimientoService;
import com.Neteam.Movimientos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    MovimientoService movimientoService;
    EmpresaService empresaServicio;
    UsuarioService usuarioServicio;

    public WebController(MovimientoService movimientoService, EmpresaService empresaServicio, UsuarioService usuarioServicio) {
        this.movimientoService = movimientoService;
        this.empresaServicio = empresaServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) { //OidcUser devuelve info del usuario, nombre, foto perfil, id
        if (principal != null) {
            Usuario usuario = this.usuarioServicio.getOrCreateUser(principal.getClaims()); //así se envía la información al servicio
            model.addAttribute("user", usuario); //para poder usar la info del usuario en el front
        }
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {//, @AuthenticationPrincipal OidcUser principal){ //OidcUser devuelve info del usuario, nombre, foto perfil, id
        /*if(principal!= null){
            Usuario usuario = this.servicioUsuario.getOrCreateUser(principal.getClaims()); //así se envía la información al servicio
            model.addAttribute("user", usuario); //para poder usar la info del usuario en el front
        }*/
        return "inicio";
    }


    @GetMapping("/empresas")
    public String verEmpresas(Model model) {
        List<Empresa> empresas = this.empresaServicio.getEnterpriseList();
        model.addAttribute("empresas", empresas);
        return "verEmpresas";
    }

    @GetMapping("/movimientoos")
    public String VerMovimiento(Model model) {
        List<Movimiento> movimientos = movimientoService.verMovimiento();
        model.addAttribute("movimientoos", movimientos);
        return "verMovimiento";
    }


    @GetMapping("/agregarmovimiento")
    public String AgregarMovimiento(Model model) {
        Movimiento movimiento = new Movimiento();
        model.addAttribute("movimiento", movimiento);
        return "agregarMovimiento";
    }

    @GetMapping("/empresas/nueva")
    public String nuevaEmpresa(Model model) {
        Empresa empresa = new Empresa();
        model.addAttribute("empresa", empresa);
        return "crearEmpresa";
    }

    @PostMapping("/guardarmovimiento")
    public String guardarMovimiento(Movimiento movimiento, RedirectAttributes redirectAttributes) {
        movimientoService.guardarMovimiento(movimiento);
        return "redirect:/movimientoos";
    }

    @GetMapping("/editarmovimiento/{id}")
    public String editarMovimento(Model model, @PathVariable Long id) {
        Movimiento movimiento = movimientoService.verMovimientoPorId(id);
        model.addAttribute("movimiento", movimiento);
        return "editarMovimiento";
    }

    @PostMapping("/actualizarmovimiento")
    public String actualizarmovimiento(@DateTimeFormat(pattern = "YYYY-MM-DD HH:MM:SS") Movimiento movimiento) {
        movimientoService.guardarMovimiento(movimiento);
        return "redirect:/movimientoos";
    }

    @GetMapping("/eliminarmovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Long id) {
        movimientoService.eliminarMovimiento(id);
        return "redirect:/movimientoos";
    }

    //Usuario
    @GetMapping("/usuarioos")
    public String VerUsuario(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Usuario> listaUsuarios = usuarioServicio.verUsuarios();
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("usuarioos", listaUsuarios);
        return "verUsuario";
    }

    @GetMapping("/agregarusuario")
    public String nuevoUsuario(Model model,@ModelAttribute("mensaje") String mensaje){
        Usuario usua= new Usuario();
        model.addAttribute("usua", usua);
        model.addAttribute("mensaje",mensaje);
        List<Empresa> listaEmpresas= empresaServicio.getEnterpriseList();
        model.addAttribute("emprelist",listaEmpresas);
        return "agregarUsuario";}

    @PostMapping("/GuardarUsuario")
    public String guardarUsuario(Usuario usuario, RedirectAttributes redirectAttributes){
        usuarioServicio.crearUsuario(usuario);
        return "redirect:/usuarioos";
    }

    @GetMapping("/EditarUsuario/{id}")
    public String editarUsuario(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje){
        Usuario usua=usuarioServicio.usuarioporID(id);
        model.addAttribute("usua",usua);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas= empresaServicio.getEnterpriseList();
        model.addAttribute("emprelist",listaEmpresas);
        return "editarEmpleado";
    }
}
