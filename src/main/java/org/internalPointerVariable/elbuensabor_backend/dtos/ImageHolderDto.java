package org.internalPointerVariable.elbuensabor_backend.dtos;

import org.springframework.web.multipart.MultipartFile;

//interface para marcar los dtos de entrada que van a venir con imágen (archivo/MultiPartFile)
//funciona junto con el controlador y servicio bases, no pregunten cómo ni por qué pero funciona :)
public interface ImageHolderDto {
    MultipartFile getImagenFile();
    String getImagen();
    void setImagen(String imagen);
}


/*
Ejemplos de implementacion en un front de un post/put con archivo de por medio

create: async (instrumento : InstrumentoWrite, imagenFile : File | null): Promise<Instrumento> => {
        try {
            const formData = new FormData();

            if(imagenFile) {
                formData.append('imagenFile', imagenFile) //importante que aca el nombre sea imagenFile
            }

            Object.entries(instrumento).forEach(([key, value]) => {
                if (value !== null && value !== undefined) {
                    formData.append(key, value.toString());
                }
            })

            const response = await axios.post<Instrumento>(API_URL, formData)
            return response.data
        } catch (error) {
            console.error(`Error creating Instrumento:`, error);
            throw error;
        }
    },

update: async(id : number, instrumento : InstrumentoWrite, imagenFile : File | null) : Promise<Instrumento> => {
        try {
            const formData = new FormData();

            if(imagenFile) {
                formData.append('imagenFile', imagenFile)
            }

            Object.entries(instrumento).forEach(([key, value]) => {
                if (value !== null && value !== undefined) {
                    formData.append(key, value.toString());
                }
            })

            const response = await axios.put<Instrumento>(`${API_URL}/${id}`, formData)
            return response.data
        } catch (error) {
            console.error(`Error updating Instrumento:`, error);
            throw error;
        }
    },

 */
