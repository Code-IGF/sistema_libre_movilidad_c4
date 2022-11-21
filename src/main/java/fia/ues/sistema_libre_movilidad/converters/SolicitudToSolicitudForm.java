package fia.ues.sistema_libre_movilidad.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.commands.SolicitudForm;

@Component
public class SolicitudToSolicitudForm implements Converter<SolicitudViaje,SolicitudForm>{

    @Override
    @Nullable
    public SolicitudForm convert(SolicitudViaje solicitudViaje) {
        SolicitudForm solicitudForm = new SolicitudForm();
        if (solicitudViaje.getIdSolicitudViaje() != null  && !StringUtils.isEmpty(solicitudViaje.getIdSolicitudViaje())) {
            solicitudViaje.setIdSolicitudViaje(new Long(solicitudViaje.getIdSolicitudViaje()));
        }
        solicitudForm.setEstado(solicitudViaje.getEstado());
        solicitudForm.setFechaSolicitud(solicitudViaje.getFechaSolicitud());;
        solicitudForm.setMotivo(solicitudViaje.getMotivo());
        solicitudForm.setPaisOrigen(solicitudViaje.getPaisOrigen());
        solicitudForm.setPaisDestino(solicitudViaje.getPaisDestino());
        solicitudForm.setFrontera(solicitudViaje.getFrontera());
        solicitudForm.setUsuario(solicitudViaje.getUsuario());

        return solicitudForm;
    }
}
