package fia.ues.sistema_libre_movilidad.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.commands.SolicitudForm;

@Component
public class SolicitudFormToSolicitud implements Converter<SolicitudForm, SolicitudViaje>{


    @Override
    @Nullable
    public SolicitudViaje convert(SolicitudForm solicitudForm) {
        SolicitudViaje solicitudViaje = new SolicitudViaje();
        if (solicitudForm.getIdSolicitudViaje() != null  && !StringUtils.isEmpty(solicitudForm.getIdSolicitudViaje())) {
            solicitudViaje.setIdSolicitudViaje(new Long(solicitudForm.getIdSolicitudViaje()));
        }
        solicitudViaje.setEstado(solicitudForm.getEstado());
        solicitudViaje.setFechaSolicitud(solicitudForm.getFechaSolicitud());;
        solicitudViaje.setMotivo(solicitudForm.getMotivo());
        solicitudViaje.setPaisOrigen(solicitudForm.getPaisOrigen());
        solicitudViaje.setPaisDestino(solicitudForm.getPaisDestino());
        solicitudViaje.setFrontera(solicitudForm.getFrontera());
        solicitudViaje.setUsuario(solicitudForm.getUsuario());

        return solicitudViaje;
    }
}
