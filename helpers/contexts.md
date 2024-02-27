```


extends GenericServices<TypeClient, TypeClientRepository>
        implements InterfaceService<TypeClient>
```

```
 @Override
    public void setTimeDelete(TypeClient attr) {

        attr.setDeletedAt(Instant.now());
    }

    @Override
    protected TypeClientRepository getInstance() {
        return this.typeClientRepository;
    }
```
