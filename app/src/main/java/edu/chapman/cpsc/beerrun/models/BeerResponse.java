package edu.chapman.cpsc.beerrun.models;

import java.util.List;

/**
 *
 * Created by fried on 12/9/2017.
 */

public class BeerResponse {
    private int currentPage;
    private int numberOfPages;
    private int totalResults;
    private String status;
    private List<DataBean> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String name;
        private String nameDisplay;
        private String description;
        private int glasswareId;
        private int styleId;
        private String isOrganic;
        private String status;
        private String statusDisplay;
        private String createDate;
        private String updateDate;
        private GlassBean glass;
        private StyleBean style;
        private String abv;
        private LabelsBean labels;
        private String ibu;
        private int srmId;
        private int availableId;
        private String servingTemperature;
        private String servingTemperatureDisplay;
        private SrmBean srm;
        private AvailableBean available;
        private List<BreweriesBean> breweries;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNameDisplay() {
            return nameDisplay;
        }

        public void setNameDisplay(String nameDisplay) {
            this.nameDisplay = nameDisplay;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getGlasswareId() {
            return glasswareId;
        }

        public void setGlasswareId(int glasswareId) {
            this.glasswareId = glasswareId;
        }

        public int getStyleId() {
            return styleId;
        }

        public void setStyleId(int styleId) {
            this.styleId = styleId;
        }

        public String getIsOrganic() {
            return isOrganic;
        }

        public void setIsOrganic(String isOrganic) {
            this.isOrganic = isOrganic;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatusDisplay() {
            return statusDisplay;
        }

        public void setStatusDisplay(String statusDisplay) {
            this.statusDisplay = statusDisplay;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public GlassBean getGlass() {
            return glass;
        }

        public void setGlass(GlassBean glass) {
            this.glass = glass;
        }

        public StyleBean getStyle() {
            return style;
        }

        public void setStyle(StyleBean style) {
            this.style = style;
        }

        public String getAbv() {
            return abv;
        }

        public void setAbv(String abv) {
            this.abv = abv;
        }

        public LabelsBean getLabels() {
            return labels;
        }

        public void setLabels(LabelsBean labels) {
            this.labels = labels;
        }

        public String getIbu() {
            return ibu;
        }

        public void setIbu(String ibu) {
            this.ibu = ibu;
        }

        public int getSrmId() {
            return srmId;
        }

        public void setSrmId(int srmId) {
            this.srmId = srmId;
        }

        public int getAvailableId() {
            return availableId;
        }

        public void setAvailableId(int availableId) {
            this.availableId = availableId;
        }

        public String getServingTemperature() {
            return servingTemperature;
        }

        public void setServingTemperature(String servingTemperature) {
            this.servingTemperature = servingTemperature;
        }

        public String getServingTemperatureDisplay() {
            return servingTemperatureDisplay;
        }

        public void setServingTemperatureDisplay(String servingTemperatureDisplay) {
            this.servingTemperatureDisplay = servingTemperatureDisplay;
        }

        public SrmBean getSrm() {
            return srm;
        }

        public void setSrm(SrmBean srm) {
            this.srm = srm;
        }

        public AvailableBean getAvailable() {
            return available;
        }

        public void setAvailable(AvailableBean available) {
            this.available = available;
        }

        public List<BreweriesBean> getBreweries() {
            return breweries;
        }

        public void setBreweries(List<BreweriesBean> breweries) {
            this.breweries = breweries;
        }

        public static class GlassBean {
            /**
             * id : 5
             * name : Pint
             * createDate : 2012-01-03 02:41:33
             */

            private int id;
            private String name;
            private String createDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }
        }

        public static class StyleBean {
            private int id;
            private int categoryId;
            private CategoryBean category;
            private String name;
            private String shortName;
            private String description;
            private String ibuMin;
            private String ibuMax;
            private String abvMin;
            private String abvMax;
            private String srmMin;
            private String srmMax;
            private String ogMin;
            private String fgMin;
            private String fgMax;
            private String createDate;
            private String updateDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getShortName() {
                return shortName;
            }

            public void setShortName(String shortName) {
                this.shortName = shortName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIbuMin() {
                return ibuMin;
            }

            public void setIbuMin(String ibuMin) {
                this.ibuMin = ibuMin;
            }

            public String getIbuMax() {
                return ibuMax;
            }

            public void setIbuMax(String ibuMax) {
                this.ibuMax = ibuMax;
            }

            public String getAbvMin() {
                return abvMin;
            }

            public void setAbvMin(String abvMin) {
                this.abvMin = abvMin;
            }

            public String getAbvMax() {
                return abvMax;
            }

            public void setAbvMax(String abvMax) {
                this.abvMax = abvMax;
            }

            public String getSrmMin() {
                return srmMin;
            }

            public void setSrmMin(String srmMin) {
                this.srmMin = srmMin;
            }

            public String getSrmMax() {
                return srmMax;
            }

            public void setSrmMax(String srmMax) {
                this.srmMax = srmMax;
            }

            public String getOgMin() {
                return ogMin;
            }

            public void setOgMin(String ogMin) {
                this.ogMin = ogMin;
            }

            public String getFgMin() {
                return fgMin;
            }

            public void setFgMin(String fgMin) {
                this.fgMin = fgMin;
            }

            public String getFgMax() {
                return fgMax;
            }

            public void setFgMax(String fgMax) {
                this.fgMax = fgMax;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public static class CategoryBean {
                private int id;
                private String name;
                private String createDate;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }
            }
        }

        public static class LabelsBean {
            private String icon;
            private String medium;
            private String large;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }

        public static class SrmBean {
            private int id;
            private String name;
            private String hex;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHex() {
                return hex;
            }

            public void setHex(String hex) {
                this.hex = hex;
            }
        }

        public static class AvailableBean {
            private int id;
            private String name;
            private String description;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class BreweriesBean {
            private String id;
            private String name;
            private String nameShortDisplay;
            private String description;
            private String website;
            private String established;
            private String isOrganic;
            private ImagesBean images;
            private String status;
            private String statusDisplay;
            private String createDate;
            private String updateDate;
            private String isMassOwned;
            private String brandClassification;
            private List<LocationsBean> locations;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNameShortDisplay() {
                return nameShortDisplay;
            }

            public void setNameShortDisplay(String nameShortDisplay) {
                this.nameShortDisplay = nameShortDisplay;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getEstablished() {
                return established;
            }

            public void setEstablished(String established) {
                this.established = established;
            }

            public String getIsOrganic() {
                return isOrganic;
            }

            public void setIsOrganic(String isOrganic) {
                this.isOrganic = isOrganic;
            }

            public ImagesBean getImages() {
                return images;
            }

            public void setImages(ImagesBean images) {
                this.images = images;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatusDisplay() {
                return statusDisplay;
            }

            public void setStatusDisplay(String statusDisplay) {
                this.statusDisplay = statusDisplay;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getIsMassOwned() {
                return isMassOwned;
            }

            public void setIsMassOwned(String isMassOwned) {
                this.isMassOwned = isMassOwned;
            }

            public String getBrandClassification() {
                return brandClassification;
            }

            public void setBrandClassification(String brandClassification) {
                this.brandClassification = brandClassification;
            }

            public List<LocationsBean> getLocations() {
                return locations;
            }

            public void setLocations(List<LocationsBean> locations) {
                this.locations = locations;
            }

            public static class ImagesBean {
                private String icon;
                private String medium;
                private String large;
                private String squareMedium;
                private String squareLarge;

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getSquareMedium() {
                    return squareMedium;
                }

                public void setSquareMedium(String squareMedium) {
                    this.squareMedium = squareMedium;
                }

                public String getSquareLarge() {
                    return squareLarge;
                }

                public void setSquareLarge(String squareLarge) {
                    this.squareLarge = squareLarge;
                }
            }

            public static class LocationsBean {
                private String id;
                private String name;
                private String streetAddress;
                private String locality;
                private String region;
                private String postalCode;
                private String phone;
                private String website;
                private String hoursOfOperation;
                private double latitude;
                private double longitude;
                private String isPrimary;
                private String inPlanning;
                private String isClosed;
                private String openToPublic;
                private String locationType;
                private String locationTypeDisplay;
                private String countryIsoCode;
                private String status;
                private String statusDisplay;
                private String createDate;
                private String updateDate;
                private CountryBean country;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getStreetAddress() {
                    return streetAddress;
                }

                public void setStreetAddress(String streetAddress) {
                    this.streetAddress = streetAddress;
                }

                public String getLocality() {
                    return locality;
                }

                public void setLocality(String locality) {
                    this.locality = locality;
                }

                public String getRegion() {
                    return region;
                }

                public void setRegion(String region) {
                    this.region = region;
                }

                public String getPostalCode() {
                    return postalCode;
                }

                public void setPostalCode(String postalCode) {
                    this.postalCode = postalCode;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getWebsite() {
                    return website;
                }

                public void setWebsite(String website) {
                    this.website = website;
                }

                public String getHoursOfOperation() {
                    return hoursOfOperation;
                }

                public void setHoursOfOperation(String hoursOfOperation) {
                    this.hoursOfOperation = hoursOfOperation;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public String getIsPrimary() {
                    return isPrimary;
                }

                public void setIsPrimary(String isPrimary) {
                    this.isPrimary = isPrimary;
                }

                public String getInPlanning() {
                    return inPlanning;
                }

                public void setInPlanning(String inPlanning) {
                    this.inPlanning = inPlanning;
                }

                public String getIsClosed() {
                    return isClosed;
                }

                public void setIsClosed(String isClosed) {
                    this.isClosed = isClosed;
                }

                public String getOpenToPublic() {
                    return openToPublic;
                }

                public void setOpenToPublic(String openToPublic) {
                    this.openToPublic = openToPublic;
                }

                public String getLocationType() {
                    return locationType;
                }

                public void setLocationType(String locationType) {
                    this.locationType = locationType;
                }

                public String getLocationTypeDisplay() {
                    return locationTypeDisplay;
                }

                public void setLocationTypeDisplay(String locationTypeDisplay) {
                    this.locationTypeDisplay = locationTypeDisplay;
                }

                public String getCountryIsoCode() {
                    return countryIsoCode;
                }

                public void setCountryIsoCode(String countryIsoCode) {
                    this.countryIsoCode = countryIsoCode;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getStatusDisplay() {
                    return statusDisplay;
                }

                public void setStatusDisplay(String statusDisplay) {
                    this.statusDisplay = statusDisplay;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate) {
                    this.updateDate = updateDate;
                }

                public CountryBean getCountry() {
                    return country;
                }

                public void setCountry(CountryBean country) {
                    this.country = country;
                }

                public static class CountryBean {
                    /**
                     * isoCode : US
                     * name : UNITED STATES
                     * displayName : United States
                     * isoThree : USA
                     * numberCode : 840
                     * createDate : 2012-01-03 02:41:33
                     */

                    private String isoCode;
                    private String name;
                    private String displayName;
                    private String isoThree;
                    private int numberCode;
                    private String createDate;

                    public String getIsoCode() {
                        return isoCode;
                    }

                    public void setIsoCode(String isoCode) {
                        this.isoCode = isoCode;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getDisplayName() {
                        return displayName;
                    }

                    public void setDisplayName(String displayName) {
                        this.displayName = displayName;
                    }

                    public String getIsoThree() {
                        return isoThree;
                    }

                    public void setIsoThree(String isoThree) {
                        this.isoThree = isoThree;
                    }

                    public int getNumberCode() {
                        return numberCode;
                    }

                    public void setNumberCode(int numberCode) {
                        this.numberCode = numberCode;
                    }

                    public String getCreateDate() {
                        return createDate;
                    }

                    public void setCreateDate(String createDate) {
                        this.createDate = createDate;
                    }
                }
            }
        }
    }
}
