package by.test.mappers;

import by.test.dto.AddressDto;
import by.test.dto.ContactsDto;
import by.test.models.Address;
import by.test.models.Contacts;
import org.springframework.stereotype.Service;

@Service
public class ContactsMapper {
    public ContactsDto toDto(Contacts contacts)
    {
        return new ContactsDto(
                contacts.getPhone(),
                contacts.getEmail()
        );
    }

    public Contacts toEntity(ContactsDto contactsDto)
    {
        return new Contacts(
                0,
                contactsDto.getPhone(),
                contactsDto.getEmail()
        );
    }
}
