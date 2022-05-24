package com.example.tiendacarlos.principal.routes;

import com.example.tiendacarlos.entities.Pedidos;
import com.example.tiendacarlos.services.jpaservices.PedidoService;
import com.example.tiendacarlos.util.global_functions.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * Clase que se encarga de manejar las rutas de los pedidos
 */
@Controller
@RequestMapping("/pedidos")
public class PedidosRoute {

    @Autowired
    private PedidoService pedidoService;

    /**
     * Metodo que se encarga de cancelar un pedido
     * @param id
     * @param model
     * @param session
     * @return redireccion de pedidos
     */
    @GetMapping("/cancelar/{id}")
    public String cancelarPedido(@PathVariable(required = true)String id, Model model , HttpSession session){
        if(SessionUtil.hasNotUserSession(session)){
            return "redirect:/";
        }
        pedidoService.cancelarPedido(Integer.parseInt(id));
        return "redirect:/pedidos";
    }

    /**
     * Metodo que se encarga de ver un pedido
     * @param id
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/{id}")
    public String verPedido(@PathVariable(required = true)String id, Model model , HttpSession session){
        if(SessionUtil.hasNotUserSession(session)){
            return "redirect:/";
        }
        Pedidos pedido = pedidoService.findById(Integer.parseInt(id));
        if(pedido == null){
            return "redirect:/pedidos";
        }
        if(pedido.getIdUsuario() == SessionUtil.getUserSession(session).getId()) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("detalle", pedido.getDetallesPedidosById());
            model.addAttribute("usuario", pedido.getUsuariosByIdUsuario());
            return "factura";
        }
        return "pedidos";
    }
}
